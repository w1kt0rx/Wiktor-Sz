package pd19;

import pd19.domain.Book;
import pd19.domain.Loan;
import pd19.domain.Member;
import pd19.dto.*;
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

        BookDto b1 = new BookDto("9788324631766", "Effective Java", "Bloch", Year.of(2018), 2);
        BookDto b2 = new BookDto("9780134685991", "Clean Java", "Martin", Year.of(2017), 1);
        BookDto b3 = new BookDto("9781491950357", "Designing Data-Intensive Applications", "Kleppmann", Year.of(2017), 0);

        bookService.addBook(b1);
        bookService.addBook(b2);
        bookService.addBook(b3);
        memberService.register(new MemberDto("Jan", "jan@mail.com"));
        memberService.register(new MemberDto("Anna", "anna@mail.com"));

        System.out.println("dostepne ksiazki");
        bookService.findAllAvailable().forEach(book -> System.out.println(book.title()));

        System.out.println("search 'clean'");
        bookService.search("clean").forEach(book -> System.out.println(book.title()));

        System.out.println("wypozyczenia");
        loanService.borrow(new CreateLoanRequest(1L, 1L));
        loanService.borrow(new CreateLoanRequest(1L, 2L));

        System.out.println("wypozyczenia jana");
        memberService.getActiveLoans(1L)
                .forEach(loan -> System.out.println(loan.book().title()));

        System.out.println("brak kopii");
        try {
            loanService.borrow(new CreateLoanRequest(2L, 3L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("zwracanie");
        loanService.returnBook(new ReturnBookRequest(1L));

        System.out.println("po zwrocie");
        memberService.getActiveLoans(1L)
                .forEach(loan -> System.out.println(loan.book().title()));

        System.out.println("po terminie");
        List<LoanDto> overdue = loanService.findOverdue();
        System.out.println("Overdue count: " + overdue.size());
    }
}