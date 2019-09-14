package com.kidozone.entity;

import com.kidozone.entity.FoodInfo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-14T14:35:40")
@StaticMetamodel(FoodCategory.class)
public class FoodCategory_ { 

    public static volatile SingularAttribute<FoodCategory, String> foodcategoryname;
    public static volatile CollectionAttribute<FoodCategory, FoodInfo> foodInfoCollection;
    public static volatile SingularAttribute<FoodCategory, Integer> id;

}