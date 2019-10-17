package io;

import interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }
}
