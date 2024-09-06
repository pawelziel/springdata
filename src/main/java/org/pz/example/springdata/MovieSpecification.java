package org.pz.example.springdata;

import org.springframework.data.jpa.domain.Specification;

public class MovieSpecification {

    public static Specification<Movie> directorLike(String director) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("director"), director));
    }

    public static Specification<Movie> sortedByTitle() {
        return ((root, query, criteriaBuilder) -> query.orderBy(criteriaBuilder.asc(root.get("title"))).getRestriction());
    }

    public static Specification<Movie> jestFajny() {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("oscarNominations"), 10) );
    }

}
