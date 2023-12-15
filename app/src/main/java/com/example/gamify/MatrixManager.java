package com.example.gamify;

import com.cosium.matrix_communication_client.ClientEvent;
import com.cosium.matrix_communication_client.MatrixResources;
import com.cosium.matrix_communication_client.RoomResource;
import com.cosium.matrix_communication_client.Message;

import java.util.List;

public class MatrixManager
{
    MatrixResources matrix;
    RoomResource current_room;

    public MatrixManager()
    {
        matrix = MatrixResources.factory()
                .builder()
                .https()
                .hostname("matrix.org")
                .defaultPort()
                .usernamePassword("user", "secret")
                .build();
    }

    public void getRoom(String id) {
        current_room = matrix.rooms().byId(id);
    }

    public void sendMessage(String message) {
        Message msgObject = Message.builder().body("hello").build();

        current_room.sendMessage(msgObject);
    }

    public List<ClientEvent> getClientEventChunk()
    {
        return current_room.fetchEventPage("b", "", 10000L, "").chunk();
    }

    public List<ClientEvent> getClientEventState()
    {
        return current_room.fetchEventPage("b", "", 10000L, "").state();
    }
}