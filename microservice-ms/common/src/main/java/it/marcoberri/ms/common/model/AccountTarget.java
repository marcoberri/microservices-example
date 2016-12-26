package it.marcoberri.ms.common.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Entity
@Table(name = "account")
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class AccountTarget extends Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1755071971198698277L;

}