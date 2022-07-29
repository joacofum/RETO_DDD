package co.com.sofkau.cine.venta;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.cine.recepcion.values.entities.Bill;
import co.com.sofkau.cine.recepcion.values.entities.Client;
import co.com.sofkau.cine.recepcion.values.entities.Product;
import co.com.sofkau.cine.recepcion.values.entities.Seller;
import co.com.sofkau.cine.venta.events.*;

import java.util.HashSet;

public class SaleChange extends EventChange {
    SaleChange(Sale sale){
        apply((SaleCreated event) -> {
            sale.productsSet = new HashSet<>();
        });

        //Product
        apply((ProductAdded event) -> {
            Product product = new Product(event.getProductId(),event.getDescription(), event.getType(), event.getPrice());
            sale.productsSet.add(product);
        });

        apply((ProductRemoved event) -> {
            sale.productsSet.removeIf(client -> client.identity().equals(event.getProductId()));
        });

        apply((ProductDescriptionUpdated event) -> {
            Product product = sale.findProductById(event.getProductId()).orElseThrow();
            product.updateDescription(event.getDescription());
        });

        apply((PriceUpdated event) -> {
            Product product = sale.findProductById(event.getProductId()).orElseThrow();
            product.updatePrice(event.getPrice());
        });

        apply((TypeUpdated event) -> {
            Product product = sale.findProductById(event.getProductId()).orElseThrow();
            product.updateType(event.getType());
        });

        //Client
        apply((ClientAdded event) -> {
            //Restar uno a la cantidad de lugares disponibles de la sala.
            sale.client = new Client(event.getClientId(), event.getClientName(), event.getMail(), event.getPhoneNumber());
        });

        apply((ClientRemoved event) ->{
            sale.client = null;
        });

        apply((ClientNameUpdated event) -> {
            sale.client.updateName(event.getName());
        });

        apply((MailUpdated event) -> {
            sale.client.updateMail(event.getMail());
        });

        apply((PhoneUpdated event) -> {
            sale.client.updatePhone(event.getPhoneNumber());
        });

        //Seller
        apply((SellerAdded event) -> {
            sale.seller = new Seller(event.getSellerId(), event.getSellerName());
        });

        apply((SellerRemoved event) -> {
            sale.seller = null;
        });

        apply((SellerNameUpdated event) -> {
            sale.seller.updateName(event.getName());
        });

        //Bill
        apply((BillAdded event) -> {
            sale.bill = new Bill(event.getBillId(), event.getBillDescription());
        });

        apply((BillRemoved event) -> {
            sale.bill = null;
        });

        apply((BillDescriptionUpdated event) -> {
            sale.bill.updateBillDescription(event.getBillDescription());
        });
    }
}
