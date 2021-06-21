package front;


import model.merchant.Merchant;

import service.merchant.MerchantService;

import java.util.Scanner;

public class MerchantFront extends BaseResponse{

    public static void addMerchant(
            MerchantService merchantService
    ) {
        Scanner scanner = new Scanner(System.in);
        Merchant merchant = new Merchant();


        System.out.print("merchant name: ");
        merchant.setName(scanner.nextLine());

        System.out.print("merchant id: ");
        merchant.setId(scanner.nextInt());

        scanner = new Scanner(System.in);
        System.out.print("merchant minAmount: ");
        merchant.setMinAmount(scanner.nextBigDecimal());

        System.out.print("merchant maxAmount: ");
        merchant.setMaxAmount(scanner.nextBigDecimal());


        boolean status = merchantService.add(merchant);
        response(status);
    }

}
