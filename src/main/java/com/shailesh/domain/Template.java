package com.shailesh.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TEMPLATE_DEF")
@Getter
@Setter
public class Template {

    @Column(name="TEMPLATE_ID")
    @Id
    private String nettingTemplateId;
    @Column(name="TEMPLATE_NAME")
    private String templateName;
    @Column(name="LAST_UPDATE")
    private Date lastUpdate;
    @Column(name="UPDATE_USER_ID")
    private Integer updUsrId;
    @Column(name="ACTIVE_FLAG")
    private Character activeFlag;
    @Column(name="VERSION")
    private Integer Version;
    @Column(name="CREATION_DATE")
    private Date creationDate;
    @Column(name="CREATE_USER_ID")
    private Integer createUsrId;


}