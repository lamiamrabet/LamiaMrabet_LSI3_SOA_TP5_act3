package client;

import proxy.BanqueService;
import proxy.BanqueServiceService;
import proxy.Compte;

import java.util.List;

public class ClientJWS {
    public static void main(String[] args){
        BanqueService proxy = new BanqueServiceService().getBanqueServicePort();
        System.out.println(proxy.conversion(300));
        Compte cmt = proxy.getCompte(5);
        cmt.setSolde(100000.0);
        System.out.println(cmt.getCode()+" "+ cmt.getSolde());
        List<Compte> cmts = proxy.getComptes();
        cmts.forEach(
                cp -> {
                    System.out.println(cp.getCode()+" "+ cp.getSolde());
                }
        );
    }
}
