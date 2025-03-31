package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Player;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {

    private final LayoutInflater inflater;
    private List<Player> playerList;

    public PlayerAdapter(Context context, List<Player> playerList) {
        this.inflater = LayoutInflater.from(context);
        this.playerList = playerList;
    }
    public void updatePlayers(List<Player> newPlayerList) {
        this.playerList = newPlayerList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.list_item_layout, parent, false);
        return new PlayerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        if (playerList != null) {
            Player currentPlayer = playerList.get(position);
            holder.bind(currentPlayer);
        }
    }

    @Override
    public int getItemCount() {
        return playerList != null ? playerList.size() : 0;
    }

    static class PlayerViewHolder extends RecyclerView.ViewHolder {
        private final TextView primaryTextView;
        private final TextView secondaryTextView;
        private final TextView tertiaryTextView;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            primaryTextView = itemView.findViewById(R.id.text_primary);
            secondaryTextView = itemView.findViewById(R.id.text_secondary);
            tertiaryTextView = itemView.findViewById(R.id.text_tertiary);
        }

        void bind(Player player) {
            primaryTextView.setText(player.getName() + " (#" + player.getJerseyNumber() + ")");
            secondaryTextView.setText("Position: " + player.getPosition());
            tertiaryTextView.setText("Team: " + player.getCurrentTeam() + " | Age: " + player.getAge());
        }
    }
}