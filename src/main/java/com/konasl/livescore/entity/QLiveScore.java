package com.konasl.livescore.entity;

import com.querydsl.core.types.dsl.Coalesce;
import com.querydsl.core.types.dsl.StringExpression;

public class QLiveScore {
    public static QLiveScore liveScore;
    public StringExpression title;
    public Coalesce<Comparable> updatedAt;
}
