package com.tylersuehr.chipexample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.tylersuehr.chips.Chip;
import com.tylersuehr.chips.ChipDataSource;
import com.tylersuehr.chips.ChipsInputLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2017 Tyler Suehr
 *
 * @author Tyler Suehr
 * @version 1.0
 */
public class MainActivity extends ContactLoadingActivity
    implements ContactOnChipAdapter.OnContactClickListener {

    private ChipsInputLayout mChipsInput;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setup chips input
        mChipsInput = findViewById(R.id.chips_input);

        List<Chip> chipsToAdd = new ArrayList<>();
        ContactChip c0 = new ContactChip();
        c0.setName("one");
        chipsToAdd.add(c0);

        mChipsInput.addFilteredChip(new TextChip("one"));
        mChipsInput.addFilteredChip(new TextChip("two"));
        mChipsInput.addFilteredChip(new TextChip("twin"));
        mChipsInput.addFilteredChip(new TextChip("three"));
        mChipsInput.addFilteredChip(new TextChip("four"));
        mChipsInput.addFilteredChip(new TextChip("five"));
        mChipsInput.addFilteredChip(new TextChip("fire"));
        mChipsInput.addFilteredChip(new TextChip("six"));
        mChipsInput.addFilteredChip(new TextChip("seven"));
        mChipsInput.addFilteredChip(new TextChip("once"));

        final ChipDataSource chipDataSource = mChipsInput.getChipDataSource();
        List<Chip> filteredChips = chipDataSource.getFilteredChips();
        for (int i = chipsToAdd.size() - 1; i >= 0; i--) {
            Chip chip = chipsToAdd.get(i);
            boolean isTaken = false;
            for (Chip filteredChip : filteredChips) {
                if (filteredChip.getTitle().equals(chip.getTitle())) {
                    chipDataSource.takeChip(filteredChip);
                    isTaken = true;
                    break;
                }
            }
            if (!isTaken) {
                chipDataSource.addSelectedChip(chip);
            }
        }

//        loadContactsWithRuntimePermission();
    }

    /**
     * When we have contact chips available, let's make them filterable in our ChipsInputView!
     */
    @Override
    protected void onContactsAvailable(List<ContactChip> chips) {
        System.out.println("Number of contacts: " + chips.size());
//        mChipsInput.setFilterableChipList(chips);
    }

    @Override
    protected void onContactsReset() {
    }

    @Override
    public void onContactClicked(ContactChip chip) {
    }
}