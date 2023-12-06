package com.example.gamify;

import com.cosium.matrix_communication_client.MatrixResources;

public class MatrixManager
{
    public MatrixManager()
    {
        MatrixResources matrix = MatrixResources.factory()
                .builder()
                .https()
                .hostname("matrix.example.org")
                .defaultPort()
                .usernamePassword("user", "secret")
                .build();
    }
}