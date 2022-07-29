package co.com.sofkau.cine.venta;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.sala.values.PhoneNumber;
import co.com.sofkau.cine.venta.entities.Bill;
import co.com.sofkau.cine.venta.entities.Client;
import co.com.sofkau.cine.venta.entities.Seller;
import co.com.sofkau.cine.venta.events.*;
import co.com.sofkau.cine.venta.values.*;

import java.util.List;
import java.util.Set;

public class Sale extends AggregateEvent<SaleId> {
    protected Set<Product> productsSet;
    protected Seller seller;
    protected Set<Client> clientSet;
    protected Bill bill;

    public Sale(SaleId entityId) {
        super(entityId);
    }

    public static Sale from(SaleId saleId, List<DomainEvent> domainEvents) {
        Sale sale = new Sale(saleId);
        domainEvents.forEach(sale::applyEvent);
        return sale;
    }

    //Events
    public void addProduct(Description description, Type type, Price price){
        ProductId productId = new ProductId();
        appendChange(new ProductAdded(productId, description, type, price)).apply();
    }

    public void removeProduct(ProductId productId) {
        appendChange(new ProductRemoved(productId)).apply();
    }

    public void addClient(ClientName clientName, Mail mail, PhoneNumber phoneNumber){
        ClientId clientId = new ClientId();
        appendChange(new ClientAdded(clientId, clientName, mail, phoneNumber)).apply();
    }

    public void removeClient(ClientId clientId){
        appendChange(new ClientRemoved(clientId)).apply();
    }

    public void addBill(Description description){
        BillId billId = new BillId();
        appendChange(new BillAdded(billId,description)).apply();
    }

    public void removeBill(BillId billId){
        appendChange(new BillRemoved(billId)).apply();
    }

    public void addSeller(SellerName sellerName){
        SellerId sellerId = new SellerId();
        appendChange(new SellerAdded(sellerId, sellerName)).apply();
    }

    public void removeSeller(SellerId sellerId){
        appendChange(new SellerRemoved(sellerId)).apply();
    }




}
