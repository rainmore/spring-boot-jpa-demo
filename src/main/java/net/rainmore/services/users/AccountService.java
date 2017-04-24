package net.rainmore.services.users;

import net.rainmore.domains.users.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional(readOnly = true)
public class AccountService {

    private AccountRepository accountRepository;

    @Inject
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getSystemAccount() {
        return findOne(1L);
    }

    public Account findOne(Long id) {
        return accountRepository.findOne(id);
    }

    @Transactional
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
