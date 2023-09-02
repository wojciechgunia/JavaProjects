package com.example.product.service;

import com.example.product.entity.ProductDTO;
import com.example.product.entity.ProductEntity;
import com.example.product.repository.CategoryRepository;
import com.example.product.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService
{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @PersistenceContext
    EntityManager entityMenager;

    public long countActiveProducts(String name, String category, Float priceMin, Float priceMax){
        CriteriaBuilder criteriaBuilder = entityMenager.getCriteriaBuilder();
        CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
        Root<ProductEntity> root = query.from(ProductEntity.class);
        List<Predicate> predicates = prepareQuery(name,category,priceMin,priceMax,criteriaBuilder,root);
        query.select(criteriaBuilder.count(root)).where(predicates.toArray(new Predicate[0]));
        return entityMenager.createQuery(query).getSingleResult();
    }
    public ProductDTO getProductDTO()
    {
        return null;
    }

    public List<ProductEntity> getProduct(String name, String category, Float priceMin, Float priceMax, String data, int page, int limit)
    {
        CriteriaBuilder criteriaBuilder = entityMenager.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> query = criteriaBuilder.createQuery(ProductEntity.class);
        Root<ProductEntity> root = query.from(ProductEntity.class);

        if (data != null && !data.equals("") && name != null && !name.trim().equals(""))
        {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate date = LocalDate.parse(data, inputFormatter);
            return productRepository.findByNameAndCreateAt(name, date);
        }
        page=lowerThanOne(page);
        limit=lowerThanOne(limit);
        List<Predicate> predicates = prepareQuery(name,category,priceMin,priceMax,criteriaBuilder,root);
        query.where(predicates.toArray(new Predicate[0]));
        return entityMenager.createQuery(query).setFirstResult((page-1)*limit).setMaxResults(limit).getResultList();
    }

    private int lowerThanOne(int number)
    {
        if(number<1)
        {
            return 1;
        }
        return number;
    }

    private List<Predicate> prepareQuery(String name, String category, Float priceMin, Float priceMax, CriteriaBuilder criteriaBuilder,Root<ProductEntity> root)
    {
        List<Predicate> predicates = new ArrayList<>();
        if(name != null && !name.trim().equals(""))
        {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
        }
        if(category != null && !category.equals(""))
        {
            categoryRepository.findByShortId(category).
                    ifPresent(value -> predicates.add(criteriaBuilder.equal(root.get("category"), value)));
        }
        if(priceMin != null)
        {
            predicates.add(criteriaBuilder.greaterThan(root.get("price"),priceMin-0.01));
        }
        if(priceMax != null)
        {
            predicates.add(criteriaBuilder.lessThan(root.get("price"),priceMax+0.01));
        }
        return predicates;
    }
}
