package be.vdab.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Authority;
import be.vdab.valueobjects.AuthorityPK;

public interface AuthorityDAO extends JpaRepository<Authority,AuthorityPK> {

}