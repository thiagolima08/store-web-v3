package br.edu.ifpb.padroes.storewebv3.visitor;

import br.edu.ifpb.padroes.storewebv3.domain.Book;
import br.edu.ifpb.padroes.storewebv3.domain.Computer;

public class DiscountVisitor implements Visitor {
    private final Double PERCENTAGE_BOOK_DISCOUNT = 0.4;
    private final Double PERCENTAGE_COMPUTER_DISCOUNT = 0.1;

    @Override
    public void visit(Book book) {
        Long newPrice = applyDiscount(book.getPrice(), PERCENTAGE_BOOK_DISCOUNT);
        book.setPrice(newPrice);
    }

    @Override
    public void visit(Computer computer) {
        Long newPrice = applyDiscount(computer.getPrice(), PERCENTAGE_COMPUTER_DISCOUNT);
        computer.setPrice(newPrice);
    }

    private Long applyDiscount(Long price, Double percentage) {
        Double discount = price * percentage;
        Long newPrice =  price - discount.longValue();
        return newPrice;
    }

}
