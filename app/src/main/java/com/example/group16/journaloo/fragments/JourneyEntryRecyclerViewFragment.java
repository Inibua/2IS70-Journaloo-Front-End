package com.example.group16.journaloo.fragments;

import android.os.Bundle;

public class JourneyEntryRecyclerViewFragment extends EntryRecyclerViewFragment {
    private int journeyId;

    public static JourneyEntryRecyclerViewFragment newInstance(int journeyId) {
        JourneyEntryRecyclerViewFragment frag = new JourneyEntryRecyclerViewFragment();
        Bundle args = new Bundle();
        args.putInt("journeyId", journeyId);
        frag.setArguments(args);

        return frag;
    }

    @Override
    protected void loadMoreItems() {
        super.loadMoreItems();
        wrapper.getJourneyEntries(journeyId, currentPage, responseHandler);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        journeyId = getArguments().getInt("journeyId", -1);
    }
}