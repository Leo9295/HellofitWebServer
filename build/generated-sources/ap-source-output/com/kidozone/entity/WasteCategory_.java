package com.kidozone.entity;

import com.kidozone.entity.WasteInfo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-14T17:52:31")
@StaticMetamodel(WasteCategory.class)
public class WasteCategory_ { 

    public static volatile CollectionAttribute<WasteCategory, WasteInfo> wasteInfoCollection;
    public static volatile SingularAttribute<WasteCategory, String> wastecategoryname;
    public static volatile SingularAttribute<WasteCategory, Integer> id;

}