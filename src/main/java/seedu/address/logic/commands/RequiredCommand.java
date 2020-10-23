package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.storage.RequiredCommandMessages.FOUNDATION_PATH;
import static seedu.address.storage.RequiredCommandMessages.INTERNSHIP_PATH;
import static seedu.address.storage.RequiredCommandMessages.ITPROF_PATH;
import static seedu.address.storage.RequiredCommandMessages.MATHANDSCI_PATH;
import static seedu.address.storage.RequiredCommandMessages.MESSAGE_FAILURE;
import static seedu.address.storage.RequiredCommandMessages.MESSAGE_FOUNDATION;
import static seedu.address.storage.RequiredCommandMessages.MESSAGE_INTERN_1;
import static seedu.address.storage.RequiredCommandMessages.MESSAGE_INTERN_2;
import static seedu.address.storage.RequiredCommandMessages.MESSAGE_ITPROF;
import static seedu.address.storage.RequiredCommandMessages.MESSAGE_MATHANDSCI;
import static seedu.address.storage.RequiredCommandMessages.MESSAGE_SCIENCE;
import static seedu.address.storage.RequiredCommandMessages.MESSAGE_SUCCESS_FOUNDATION;
import static seedu.address.storage.RequiredCommandMessages.MESSAGE_SUCCESS_INTERN;
import static seedu.address.storage.RequiredCommandMessages.MESSAGE_SUCCESS_ITPROF;
import static seedu.address.storage.RequiredCommandMessages.MESSAGE_SUCCESS_MATHANDSCI;
import static seedu.address.storage.RequiredCommandMessages.MESSAGE_SUCCESS_SCIENCE;
import static seedu.address.storage.RequiredCommandMessages.SCIENCE_PATH;

import java.io.IOException;

import javafx.collections.ObservableList;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.Model;
import seedu.address.model.module.Module;
import seedu.address.storage.RequiredCommandStorage;

public class RequiredCommand extends Command {
    public static final String COMMAND_WORD = "required";

    private ObservableList<Module> currentModules;
    private String leftOverModules = "";
    private RequiredCommandStorage storage;

    /**
     * Retrieves the leftOverModules attribute of a RequiredCommand object.
     * @return leftOverModules of type String.
     */
    public String getLeftOverModules() {
        return leftOverModules;
    }

    /**
     * Retrieves the attribute storage of a RequiredCommand object.
     * @return storage attribute of type RequiredCommandStorage.
     */
    public RequiredCommandStorage getStorage() {
        return storage;
    }

    /**
     * Sets up the storage attribute with all the relevant modules from various fields.
     * @throws IOException When path is invalid.
     * @throws DataConversionException When there is an error converting from the JSON file.
     */
    public void setStorage() throws IOException, DataConversionException {
        storage = new RequiredCommandStorage();
        storage.setRequiredFoundation(FOUNDATION_PATH);
        storage.setRequiredITprof(ITPROF_PATH);
        storage.setRequiredMathAndScience(MATHANDSCI_PATH);
        storage.setRequiredScience(SCIENCE_PATH);
        storage.setRequiredInternship(INTERNSHIP_PATH);
    }

    /**
     * Retrieves the currentModules attribute of an Required Command object.
     * @return currentModules attribute of type ObservableList<Module/>.
     */
    public ObservableList<Module> getCurrentModules() {
        return currentModules;
    }

    /**
     * Sets the argument modules as the attribute currentModules.
     * @param modules target argument of type ObservableList<Module/>.
     */
    public void setCurrentModules(ObservableList<Module> modules) {
        currentModules = modules;
    }

    /**
     * Checks if a Module already exists in a given Module List.
     * @param module Module that you wish to check.
     * @param modules Module List that you wish to check against.
     * @return True if the module already exists, false otherwise.
     */
    public boolean doesModuleAlreadyExist(Module module, ObservableList<Module> modules) {
        for (Module mod : modules) {
            if (module.isSameModule(mod)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Cross references the user's current list of Modules against the given
     * modules argument and marks out any undone Modules. Displays a successMessage
     * if all modules are done, and a failMessage if there are left over modules.
     * @param modules List of Modules of a certain category (Eg. Foundation, IT Professsionalism)
     * @param failMessage Fail message for particular category of Modules.
     * @param successMessage Success message for particular category of Modules.
     */
    public void compareModules(ObservableList<Module> modules, String failMessage, String successMessage) {
        boolean areModulesCleared = true;
        StringBuilder modulesToAdd = new StringBuilder();
        for (Module module : modules) {
            if (!doesModuleAlreadyExist(module, currentModules)) {
                String moduleToAdd = module.getModuleCode() + " (" + module.getModularCredits() + " MCs)";
                modulesToAdd.append("\n").append(moduleToAdd);
                areModulesCleared = false;
            }
        } if (areModulesCleared) {
            leftOverModules += successMessage + "\n";
        } else {
            leftOverModules += failMessage + modulesToAdd + "\n";
        }
        leftOverModules += "\n";
    }

    /**
     * Cross references the user's current list of Modules and marks out
     * any undone Science Modules.
     */
    public void compareScience(ObservableList<Module> requiredScience) {
        boolean areModulesCleared = true;
        for (Module module : requiredScience) {
            if (doesModuleAlreadyExist(module, currentModules)) {
                leftOverModules += MESSAGE_SUCCESS_SCIENCE + "\n";
                areModulesCleared = false;
                break;
            }
        } if (areModulesCleared) {
            leftOverModules += MESSAGE_SCIENCE + "\n";
        }
        leftOverModules += "\n";
    }

    /**
     * Cross references the user's current list of Modules and marks out
     * any undone Internship Modules. Also calculates current MC score
     * achieved from Internship Modules.
     */
    public void compareInternship(ObservableList<Module> requiredInternship) {
        int modularScore = 0;
        StringBuilder leftOverInternship = new StringBuilder();
        for (Module module : requiredInternship) {
            boolean areModulesCleared = true;
            if (doesModuleAlreadyExist(module, currentModules)) {
                int modularCredits = Integer.parseInt(module.getModularCredits().toString());
                modularScore += modularCredits;
                areModulesCleared = false;
            }
            if (areModulesCleared) {
                String moduleToAdd = module.getModuleCode() + " (" + module.getModularCredits() + " MCs)";
                leftOverInternship.append("\n").append(moduleToAdd);
            }
        } if (modularScore < 12) {
            String modScore = " You are currently at " + modularScore + " MCs. ";
            leftOverModules += MESSAGE_INTERN_1 + modScore + MESSAGE_INTERN_2 + leftOverInternship;
        } else {
            leftOverModules += MESSAGE_SUCCESS_INTERN;
        }
    }

    /**
     * Sets up the reference modules and the current modules in gradPad and compares all the modules.
     * @param model {@code Model} which the command should operate on.
     * @return a CommandResult displaying all the undone modules.
     */
    @Override
    public CommandResult execute(Model model) {
        try {
            requireNonNull(model);
            currentModules = model.getGradPad().getModuleList();
            setStorage();
            ObservableList<Module> requiredFoundation = storage.getRequiredFoundation();
            ObservableList<Module> requiredITprof = storage.getRequiredITprof();
            ObservableList<Module> requiredMathAndScience = storage.getRequiredMathAndScience();
            ObservableList<Module> requiredScience = storage.getRequiredScience();
            ObservableList<Module> requiredInternship = storage.getRequiredInternship();
            compareModules(requiredFoundation, MESSAGE_FOUNDATION, MESSAGE_SUCCESS_FOUNDATION);
            compareModules(requiredITprof, MESSAGE_ITPROF, MESSAGE_SUCCESS_ITPROF);
            compareModules(requiredMathAndScience, MESSAGE_MATHANDSCI, MESSAGE_SUCCESS_MATHANDSCI);
            compareScience(requiredScience);
            compareInternship(requiredInternship);
            return new CommandResult(leftOverModules);
        } catch (DataConversionException | IOException e) {
            return new CommandResult(MESSAGE_FAILURE);
        }
    }
}
