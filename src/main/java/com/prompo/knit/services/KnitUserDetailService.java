package com.prompo.knit.services;

import com.prompo.knit.Dao.SellerService;
import com.prompo.knit.model.Seller;
import com.prompo.knit.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class KnitUserDetailService extends InMemoryUserDetailsManager {
    @Autowired
    private SellerService sellerService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Seller user = sellerService.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);

    }

}
