package co.edu.poli.shoppingservice.clientFeign;

import co.edu.poli.shoppingservice.helpers.Response;
import co.edu.poli.shoppingservice.helpers.ResponseBuild;
import co.edu.poli.shoppingservice.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerClientImplHystrix implements CustomerClient{

    private final ResponseBuild build;

    @Override
    public Response findByNumberID(String numberID) {
        return build.success(new Customer());
    }

    @Override
    public Response findByID(Long id) {
        return build.success(new Customer());
    }
}
