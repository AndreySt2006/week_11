package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R; // Replace with your actual R file import
import com.example.myapplication.model.Team;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.TeamViewHolder> {

    private final LayoutInflater inflater;
    private List<Team> teamList;

    public DataAdapter(Context context, List<Team> teamList) {
        this.inflater = LayoutInflater.from(context);
        this.teamList = teamList;
    }

    public void updateTeams(List<Team> newTeamList) {
        this.teamList = newTeamList;
        notifyDataSetChanged(); // Tell RecyclerView to redraw
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate your list item layout for teams (e.g., R.layout.list_item_team)
        View itemView = inflater.inflate(R.layout.list_item_layout, parent, false); // Use your layout ID
        return new TeamViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        if (teamList != null) {
            Team currentTeam = teamList.get(position);
            holder.bind(currentTeam);
        }
    }

    @Override
    public int getItemCount() {
        return teamList != null ? teamList.size() : 0;
    }

    static class TeamViewHolder extends RecyclerView.ViewHolder {
        private final TextView primaryTextView;
        private final TextView secondaryTextView;
        private final TextView tertiaryTextView;


        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            // Find views in your list_item_layout.xml
            primaryTextView = itemView.findViewById(R.id.text_primary);
            secondaryTextView = itemView.findViewById(R.id.text_secondary);
            tertiaryTextView = itemView.findViewById(R.id.text_tertiary);
        }

        void bind(Team team) {
            primaryTextView.setText(team.getName());
            secondaryTextView.setText("League: " + team.getLeague());
            tertiaryTextView.setText("Country: " + team.getCountry());
        }
    }
}