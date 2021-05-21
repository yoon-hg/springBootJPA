package com.example.jpasetting.model;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class UserRepositoryCustomImpl extends QuerydslRepositorySupport implements UserRepositoryCustom {

    public UserRepositoryCustomImpl() { super(User.class); }

    @Override
    public Page<User> findByAll() {
        QUser user = QUser.user;
        JPAQueryFactory factory = new JPAQueryFactory(this.getEntityManager());
        QueryResults<User> results =factory.select(Projections.fields(User.class,
                    user.id.as("id"),
                    user.username.as("username"),
                    user.password.as("password"),
                    user.userType.as("userType"),
                    user.created.as("created")
                ))
                .from(user)
                .offset(0)
                .limit(10)
                .fetchResults();
        return new PageImpl<>(results.getResults(), Pageable.unpaged(), results.getTotal());


    }
}
