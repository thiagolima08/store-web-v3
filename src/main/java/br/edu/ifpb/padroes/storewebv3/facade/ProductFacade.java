package br.edu.ifpb.padroes.storewebv3.facade;

import br.edu.ifpb.padroes.storewebv3.domain.Product;
import br.edu.ifpb.padroes.storewebv3.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductFacade {

    private final ProductRepository productRepository;

    public ProductFacade(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listAllProducts() {
        return productRepository.getProductList();
    }

}
