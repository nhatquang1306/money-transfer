package com.techelevator;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Television {
    private boolean isOn;
    private int currentChannel;
    private int currentVolume;

    //Constructor variable things???
        public Television() {
            isOn = false;
            currentChannel = 3;
            currentVolume = 2;
        }
        public void turnOff() {
            isOn = false;
        }
        public void turnOn() {
            isOn = true;
            currentChannel = 3;
            currentVolume = 2;
        }
        //Methods based on signatures
        public void changeChannel(int newChannel) {
            if (isOn && newChannel >= 3 && newChannel <= 18) {
                currentChannel = newChannel;
            }
        }
        public void channelUp() {
            if (isOn) {
                currentChannel++;
                if (currentChannel > 18) {
                    currentChannel = 3;
                }
            }
        }
        public void channelDown() {
            if (isOn) {
                currentChannel--;
                if (currentChannel < 3) {
                    currentChannel = 18;
                }
            }
        }
        public void raiseVolume() {
            if (isOn && currentVolume < 10) {
                currentVolume++;
            }
        }
        public void lowerVolume() {
            if (isOn && currentVolume > 0) {
                currentVolume--;
            }
        }
        public boolean isOn() {
            return isOn;
        }
        public int getCurrentChannel() {
            return currentChannel;
        }
        public int getCurrentVolume() {
            return currentVolume;
        }
    }
