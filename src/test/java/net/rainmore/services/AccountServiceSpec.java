package net.rainmore.services;

import net.rainmore.BaseSpec;
import net.rainmore.domains.locations.Area;
import net.rainmore.domains.locations.Country;
import net.rainmore.domains.users.Account;
import net.rainmore.domains.users.AccountArea;
import net.rainmore.services.locations.AreaRepository;
import net.rainmore.services.users.AccountService;
import org.junit.Assert;
import org.junit.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

public class AccountServiceSpec extends BaseSpec {

    @Inject
    private AccountService accountService;

    @Inject
    private AreaRepository areaRepository;

    private static final Long SM001 = 285L;
    private static final Long AM001 = 28L;

    private static final Long LOCATION_AREA_001 = 38L;



    @Test
    @Transactional
    public void testFindOne() {

        Account account = accountService.findOne(AM001);

        Area area = areaRepository.findOne(LOCATION_AREA_001);

        processAccount(account, area);

        accountService.save(account);

    }

    private void processAccount(Account account, Area area) {

        account.resetAccountAreas();

        AccountArea accountArea = new AccountArea(account, area, true);

        account.addAccountArea(accountArea);

        account.setTimezone(accountService.getSystemAccount().getTimezone());

    }
}
