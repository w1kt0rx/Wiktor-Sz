package pd19;

import pd19.domain.Book;
import pd19.domain.Member;
import pd19.repository.BookRepository;
import pd19.repository.LoanRepository;
import pd19.repository.MemberRepository;
import pd19.service.impl.BookServiceImpl;
import pd19.service.impl.LoanServiceImpl;
import pd19.service.impl.MemberServiceImpl;

import java.time.Year;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        BookRepository bookRepository = new BookRepository();
        MemberRepository memberRepository = new MemberRepository();
        LoanRepository loanRepository = new LoanRepository();

        BookServiceImpl bookService = new BookServiceImpl(bookRepository);
        MemberServiceImpl memberService = new MemberServiceImpl(memberRepository);
        LoanServiceImpl loanService =
                new LoanServiceImpl(loanRepository, memberRepository, bookRepository);

        Book b1 = Book.of("9788324631766", "Effective Java", "Bloch", Year.of(2018), 2);
        Book b2 = Book.of("9780134685991", "Clean Architecture", "Martin", Year.of(2017), 1);
        Book b3 = Book.of("9781491950357", "Designing Data-Intensive Applications", "Kleppmann", Year.of(2017), 0);

        bookService.addBook(b1);
        bookService.addBook(b2);
        bookService.addBook(b3);

        Member m1 = memberService.register("Jan", "jan@mail.com");
        Member m2 = memberService.register("Anna", "anna@mail.com");

        System.out.println("\nDOSTĘPNE KSIĄŻKI");
        bookService.findAvailable().forEach(b -> System.out.println(b.getTitle()));

        System.out.println("\nSEARCH 'clean'");
        bookService.search("clean").forEach(b -> System.out.println(b.getTitle()));

        System.out.println("\nWYPOŻYCZENIA");
        loanService.borrow(m1.getId(), b1.getId());
        loanService.borrow(m1.getId(), b2.getId());

        System.out.println("\nAKTYWNE WYPOŻYCZENIA JAN");
        memberService.getActiveLoans(m1.getId())
                .forEach(l -> System.out.println(l.getBook().getTitle()));

        System.out.println("\nPRÓBA WYPOŻYCZENIA BRAK KOPII");
        try {
            loanService.borrow(m2.getId(), b3.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nZWROT");
        loanService.returnBook(1L);

        System.out.println("\nPO ZWROCIE");
        memberService.getActiveLoans(m1.getId())
                .forEach(l -> System.out.println(l.getBook().getTitle()));

        System.out.println("\nPRZETERMINOWANE");
        List<?> overdue = loanService.findOverdue();
        System.out.println("Overdue count: " + overdue.size());
    }
}