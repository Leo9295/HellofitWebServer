package com.kidozone.entity;

import com.kidozone.entity.FoodCategory;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-14T17:52:31")
@StaticMetamodel(FoodInfo.class)
public class FoodInfo_ { 

    public static volatile SingularAttribute<FoodInfo, String> foodname;
    public static volatile SingularAttribute<FoodInfo, Integer> id;
    public static volatile SingularAttribute<FoodInfo, String> foodimagepath;
    public static volatile SingularAttribute<FoodInfo, FoodCategory> foodcategory;
    public static volatile SingularAttribute<FoodInfo, Integer> foodranking;

}