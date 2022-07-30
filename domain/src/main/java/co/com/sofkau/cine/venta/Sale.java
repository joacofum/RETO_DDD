package co.com.sofkau.cine.venta;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.cine.recepcion.events.ReceptionCreated;
import co.com.sofkau.cine.venta.values.PhoneNumber;
import co.com.sofkau.cine.venta.entities.Bill;
import co.com.sofkau.cine.venta.entities.Client;
import co.com.sofkau.cine.venta.entities.Product;
import co.com.sofkau.cine.venta.entities.Seller;
import co.com.sofkau.cine.venta.events.*;
import co.com.sofkau.cine.venta.values.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Sale extends AggregateEvent<SaleId> {
    protected Set<Product> productsSet;
    protected Seller seller;
    protected Client client;
    protected Bill bill;

    public Sale(SaleId entityId) {
        super(entityId);
        subscribe(new SaleChange(this));
        appendChange(new SaleCreated()).apply();
    }

    public static Sale from(SaleId saleId, List<DomainEvent> domainEvents) {
        Sale sale = new Sale(saleId);
        domainEvents.forEach(sale::applyEvent);
        return sale;
    }

    //Events
    //Product
    public void addProduct(Description description, Type type, Price price){
        ProductId productId = new ProductId();
        appendChange(new ProductAdded(productId, description, type, price)).apply();
    }

    public void removeProduct(ProductId productId) {
        appendChange(new ProductRemoved(productId)).apply();
    }

    public void updateProductPrice(ProductId productId, Price price){
        appendChange(new PriceUpdated(productId, price)).apply();
    }

    public void updateProductType(ProductId productId, Type type){
        appendChange(new TypeUpdated(productId, type)).apply();
    }

    public void updateProductDescription(ProductId productId, Description description){
        appendChange(new ProductDescriptionUpdated(productId, description)).apply();
    }

    //Client
    public void addClient(ClientName clientName, Mail mail, PhoneNumber phoneNumber){
        ClientId clientId = new ClientId();
        appendChange(new ClientAdded(clientId, clientName, mail, phoneNumber)).apply();
    }

    public void removeClient(ClientId clientId){
        appendChange(new ClientRemoved(clientId)).apply();
    }

    public void updateClientPhone(ClientId clientId, PhoneNumber number){
        appendChange(new PhoneUpdated(clientId, number)).apply();
    }

    public void updateClientMail(ClientId clientId, Mail mail){
        appendChange(new MailUpdated(clientId, mail)).apply();
    }

    public void updateClientName(ClientId clientId, ClientName name){
        appendChange(new ClientNameUpdated(clientId, name)).apply();
    }

    //Bill
    public void addBill(BillDescription description){
        BillId billId = new BillId();
        appendChange(new BillAdded(billId, description)).apply();
    }

    public void removeBill(BillId billId){
        appendChange(new BillRemoved(billId)).apply();
    }

    public void updateBillDescription(BillId billId, BillDescription description){
        appendChange(new BillDescriptionUpdated(billId, description)).apply();
    }

    //Seller
    public void addSeller(SellerName sellerName){
        SellerId sellerId = new SellerId();
        appendChange(new SellerAdded(sellerId, sellerName)).apply();
    }

    public void removeSeller(SellerId sellerId){
        appendChange(new SellerRemoved(sellerId)).apply();
    }

    public void updateSellerName(SellerId sellerId, SellerName name){
        appendChange(new SellerNameUpdated(sellerId, name)).apply();
    }

    //findById methods
    protected Optional<Product> findProductById(ProductId productId) {
        return this.productsSet.stream().filter(client -> client.identity().equals(productId)).findFirst();
    }

}
