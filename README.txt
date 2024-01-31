README

## Image Processing Program - GUI Implementation

This document is intended to guide users on how to use our Image Processing program, which now comes with a new Graphical User Interface (GUI). It outlines the areas of the program that are complete, explains the design changes that have been made and the reasons behind them, and provides the necessary attributions for all images used.

## Overview

This latest update is an enhancement to the Image Processing program we developed previously. We have not made any modifications to the initial framework or structural content of the original design. Instead, this update focuses on adding a GUI to improve user interaction. The new GUI is segregated into two sections: the GUI Controller and the GUI View.

## Program Structure

### GUI Directory

Our GUI directory consists of:

1. **GUI Controller**: The Controller drives the execution of the program. We have rewritten the load and save commands to ensure that image files of three different formats - PPM, PNG, and JPG - can be operated using a unified BufferedImage, thus simplifying the operations.

2. **GUI View**: The View is responsible for rendering the GUI and accepting user commands. Most of the commands are similar to the transformation strategies in the previous version, hence, the underlying logic is borrowed from the transformation strategies. The only modification is that input and output are now handled by the GUI.

We have also rewritten the main methods to enable the user to operate in three different modes through specific commands:

```
Please enter a command (-file <path-to-script-file>, -text, or <enter> for GUI):
```

## Completed Parts

All aspects of this program, including the newly added GUI, are fully functional. The user can load, manipulate, and save images in PPM, PNG, and JPG formats using a unified BufferedImage. The program supports multiple operations and transformations that can be triggered either from the GUI or using command-line instructions.

## Design Changes and Justifications

The main change in this version of the program is the addition of the GUI. The need for this enhancement came from the understanding that a graphical interface would make the program more user-friendly and intuitive. With this change, users can now interact with the program through a graphical interface, making it easier for non-technical users to perform complex operations.

## Citations for Images

All images used within this program are original and sourced from the developer's personal photo album. No third-party images have been used.
