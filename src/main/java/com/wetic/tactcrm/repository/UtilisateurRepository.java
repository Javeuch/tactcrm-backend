package com.wetic.tactcrm.repository;

import com.wetic.tactcrm.domain.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

    public Utilisateur findByEmail(String email);

    public Optional<Utilisateur> findByLogin(String login);

    public Optional<Utilisateur> findOneByLogin(String login);

    @Override
    @Query(value = "select COUNT(*) from utilisateurs WHERE utilisateurs.is_admin <> 1 OR utilisateurs.is_admin IS NULL", nativeQuery = true)
    public long count();

    @Override
    @Query(value="select * from utilisateurs WHERE utilisateurs.is_admin <> 1 OR utilisateurs.is_admin IS NULL", nativeQuery = true)
    public List<Utilisateur> findAll();

}
