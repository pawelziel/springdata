package org.pz.example.springdata;

import org.springframework.data.jpa.domain.Specification;

public class MovieSpecification {
    public static Specification<Movie> isCool() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("oscarNominations"), 10);
    }


}