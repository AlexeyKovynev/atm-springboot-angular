package name.javalex.springboot.service.impl;

import name.javalex.springboot.service.ATMService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ATMServiceImpl implements ATMService {

    private final static ArrayList<Integer> denominations = new ArrayList<>(Arrays.asList(100, 50, 20));

    @Override
    public List<Integer> getDenominations() {
        return denominations;
    }
}
