package co.edu.poli.shoppingservice.service;

import co.edu.poli.shoppingservice.clientFeign.CustomerClient;
import co.edu.poli.shoppingservice.clientFeign.ProductClient;
import co.edu.poli.shoppingservice.model.Customer;
import co.edu.poli.shoppingservice.model.Product;
import co.edu.poli.shoppingservice.persistence.entity.Invoice;
import co.edu.poli.shoppingservice.persistence.entity.InvoiceItem;
import co.edu.poli.shoppingservice.persistence.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;

    @Override
    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    @Override
    public void delete(Invoice invoice) {
        invoiceRepository.delete(invoice);
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public Invoice findByNumberInvoice(String numberInvoice) {
        Invoice invoice = invoiceRepository.findByNumberInvoice(numberInvoice);
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(customerClient.findByID(invoice.getCustomerId()).getData(),Customer.class);
        invoice.setCustomer(customer);
        List<InvoiceItem> items = invoice.getItems().stream()
                .map(invoiceItem -> {
                    Product product = modelMapper.map(productClient.findById(invoiceItem.getProductId()).getData(),Product.class);
                    invoiceItem.setProduct(product);
                    return invoiceItem;
                }).collect(Collectors.toList());
        invoice.setItems(items);
        return invoice;
    }
}
