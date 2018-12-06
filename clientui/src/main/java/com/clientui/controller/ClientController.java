package com.clientui.controller;

import com.clientui.beans.ProductBean;
import com.clientui.proxies.MicroserviceProduitsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    private MicroserviceProduitsProxy produitsProxy ;

    @RequestMapping("/")
    public String accueil(Model model) {
        List<ProductBean> produits = produitsProxy.listeDesProduits() ;
        model.addAttribute("produits", produits);
        return "Accueil" ;
    }

    @GetMapping("/details-produit/{id}")
    public String ficheProduit(@PathVariable int id, Model model) {
        Optional<ProductBean> product = produitsProxy.recupererUnProduit(id);
        if ( product.isPresent() ) {
            model.addAttribute("produit", product.get());
        }
        return "FicheProduit" ;
    }

}
