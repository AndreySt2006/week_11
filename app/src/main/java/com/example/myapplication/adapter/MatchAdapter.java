package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Match;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {

    private final LayoutInflater inflater;
    private List<Match> matchList;

    public MatchAdapter(Context context, List<Match> matchList) {
        this.inflater = LayoutInflater.from(context);
        this.matchList = matchList;
    }
    public void updateMatch(List<Match> newMatchList) {
        this.matchList = newMatchList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate your list item layout for matches (e.g., R.layout.list_item_match)
        View itemView = inflater.inflate(R.layout.list_item_layout, parent, false); // Use your layout ID
        return new MatchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        if (matchList != null) {
            Match currentMatch = matchList.get(position);
            holder.bind(currentMatch);
        }
    }

    @Override
    public int getItemCount() {
        return matchList != null ? matchList.size() : 0;
    }
    static class MatchViewHolder extends RecyclerView.ViewHolder {
        private final TextView primaryTextView;
        private final TextView secondaryTextView;
        private final TextView tertiaryTextView;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            primaryTextView = itemView.findViewById(R.id.text_primary);
            secondaryTextView = itemView.findViewById(R.id.text_secondary);
            tertiaryTextView = itemView.findViewById(R.id.text_tertiary);
        }

        void bind(Match match) {
            primaryTextView.setText(match.getName());
            secondaryTextView.setText("Competition: " + match.getCompetition());
            tertiaryTextView.setText("Date: " + match.getDate() + " | Venue: " + match.getVenue());
        }
    }
}