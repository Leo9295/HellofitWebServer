package com.kidozone.entity;

import com.kidozone.entity.WasteCategory;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-14T17:52:31")
@StaticMetamodel(WasteInfo.class)
public class WasteInfo_ { 

    public static volatile SingularAttribute<WasteInfo, WasteCategory> wastecategory;
    public static volatile SingularAttribute<WasteInfo, String> wastename;
    public static volatile SingularAttribute<WasteInfo, Integer> id;
    public static volatile SingularAttribute<WasteInfo, String> wasteimagepath;

}