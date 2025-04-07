package br.com.luan.mk1.INFRASTRUCTURE.PURCHASE;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luan.mk1.DOMAIN.PURCHASE.Purchase;
import br.com.luan.mk1.INFRASTRUCTURE.PURCHASE.SEARCHBYDTO.PurchaseSearchByDTORepository;

public interface JpaPurchaseRepository extends JpaRepository<Purchase, Long>, PurchaseSearchByDTORepository{

}
