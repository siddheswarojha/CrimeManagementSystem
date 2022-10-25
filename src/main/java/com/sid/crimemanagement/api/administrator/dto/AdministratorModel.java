package com.sid.crimemanagement.api.administrator.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class AdministratorModel extends AbstractPersistable<Long> {
}
