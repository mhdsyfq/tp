package seedu.address.commons.core;

/**
 * Container for user visible messages.
 */
public class Messages {

    // module components constraints
    public static final String MESSAGE_CONSTRAINTS_CREDITS =
        "Modular credits should only contain numbers, and it should be either 1 or 2 digits long.";
    public static final String MESSAGE_CONSTRAINTS_CODE = "A module code must have 2 or more characters as "
        + "its prefix followed by 1 or more digits as its numerical code. It can optionally end with 1 or "
        + "more characters as a suffix. It is also case-insensitive.";
    public static final String MESSAGE_CONSTRAINTS_TITLE = "Module titles should only contain alphanumeric "
        + "characters and spaces.";
    public static final String MESSAGE_CONSTRAINTS_TAG = "Tags names should be alphanumeric";

    // general
    public static final String MESSAGE_NEED_HELP = "If you need help, type \"help\".";
    public static final String MESSAGE_MORE_INFO = "For more information, type \"help\".";
    public static final String MESSAGE_EMPTY_FIELD = "Please enter a command.\n\n"
        + MESSAGE_NEED_HELP;
    public static final String MESSAGE_UNKNOWN_COMMAND = "You have entered an unknown command. Please try "
        + "again.\n\n" + MESSAGE_NEED_HELP;
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Please use the correct format for the "
        + "following command: %1$s";
    public static final String MESSAGE_DUPLICATE_MODULE = "Module with module code %1$s already exists!";
    public static final String MESSAGE_INVALID_MODULE = "Module with module code %1$s cannot be found in "
        + "GradPad!";
    public static final String MESSAGE_EMPTY_GRADPAD = "GradPad is empty!";
    public static final String MESSAGE_MODULES_FOUND_OVERVIEW = "%1$d modules found!";
    public static final String MESSAGE_INVALID_MODULE_CODE = "Please enter a valid module code.\n\n"
        + "Note:\n" + MESSAGE_CONSTRAINTS_CODE;

    // add command
    public static final String ADD_COMMAND_WORD = "add";
    public static final String MESSAGE_ADD_USAGE = ADD_COMMAND_WORD + "\n\n"
        + "Format: add MODULE_CODE [t/TAG]...\n\nNote:\n"
        + "\u2022 [ ] indicate optional fields.\n"
        + "\u2022 ... indicate fields that may have multiple instances.\n\n"
        + MESSAGE_MORE_INFO;
    public static final String MESSAGE_ADD_SUCCESS = "The following module has been successfully added:\n\n"
        + "%1$s";

    // checkmc command
    public static final String CHECKMC_COMMAND_WORD = "checkmc";
    public static final String MESSAGE_CHECKMC_SUCCESS = "You have accumulated a total of %1$d MCs so far!";

    // clear command
    public static final String CLEAR_COMMAND_WORD = "clear";
    public static final String MESSAGE_CLEAR_SUCCESS = "GradPad has been cleared!";
    public static final String MESSAGE_CLEAR_CONFIRMATION = "Are you sure you wish to clear all modules? "
        + "(yes/no)";

    // delete command
    public static final String DELETE_COMMAND_WORD = "delete";
    public static final String MESSAGE_DELETE_USAGE = DELETE_COMMAND_WORD + "\n\n"
        + "Format: delete MODULE_CODE\n\n"
        + MESSAGE_MORE_INFO;
    public static final String MESSAGE_DELETE_SUCCESS = "The following module has been successfully "
        + "deleted:\n\n%1$s";
    public static final String MESSAGE_DELETE_CONFIRMATION = "Are you sure you wish to delete the following"
        + " module? (yes/no)\n\n";

    // edit command
    public static final String EDIT_COMMAND_WORD = "edit";
    public static final String MESSAGE_EDIT_USAGE = EDIT_COMMAND_WORD + "\n\n"
        + "Format: edit MODULE_CODE [c/NEW_MODULE_CODE] [t/TAG]...\n\nNote:\n"
        + "\u2022 At least 1 field to edit must be specified.\n"
        + "\u2022 [ ] indicate optional fields.\n"
        + "\u2022 ... indicate fields that may have multiple instances.\n\n"
        + MESSAGE_MORE_INFO;
    public static final String MESSAGE_EDIT_SUCCESS = "The following module has been successfully edited:"
        + "\n\n%1$s\n\nEdited module:\n\n%2$s";
    public static final String MESSAGE_NOT_EDITED = "You must provide at least one field to edit!";

    // exit command
    public static final String EXIT_COMMAND_WORD = "exit";
    public static final String MESSAGE_EXIT_ACKNOWLEDGEMENT = "Take care!";

    // find command
    public static final String FIND_COMMAND_WORD = "find";
    public static final String MESSAGE_FIND_USAGE = FIND_COMMAND_WORD + "\n\n"
        + "Format: find [KEYWORD]... [TAG]...\n\nNote:\n"
        + "\u2022 At least 1 keyword or tag to find must be specified.\n"
        + "\u2022 [ ] indicate optional fields.\n"
        + "\u2022 ... indicate fields that may have multiple instances.\n\n"
        + MESSAGE_MORE_INFO;

    // help command
    public static final String HELP_COMMAND_WORD = "help";
    public static final String ADD_COMMAND = "To add a module:\tType \"add\" followed by a valid module "
        + "code and tags.\n"
        + "\t\t\t\t(Tags are optional and you can have any number of tags)\n\n"
        + "\t\t\t\tExample(s):\tadd cs1231\n"
        + "\t\t\t\t\t\t\tadd cs1231 t/Foundation t/Core\n\n";
    public static final String DELETE_COMMAND = "To delete a module:\tType \"delete\" followed by a valid "
        + "module code.\n\n"
        + "\t\t\t\tExample(s):\tdelete cs1231\n\n";
    public static final String EDIT_COMMAND = "To edit a module:\tType \"edit\" followed by a valid module "
        + "code and the fields\n"
        + "\t\t\t\tyou wish to edit (at least 1 field must be provided). You can\n"
        + "\t\t\t\tonly edit the module code and tags of a module by using the\n"
        + "\t\t\t\tprefixes \"c/\" and \"t/\" respectively.\n\n"
        + "\t\t\t\tNote:\n" + "\t\t\t\tEditing tags replaces existing tags with new ones instead of\n"
        + "\t\t\t\tchanging their respective descriptions. You can remove tags of a\n"
        + "\t\t\t\tmodule simply by including the aforementioned prefix without a\n"
        + "\t\t\t\tdescription as one of the edit fields, i.e., \"t/\".\n\n"
        + "\t\t\t\tExample(s):\tedit cs1231 c/cs2100\n"
        + "\t\t\t\t\t\t\tedit cs1231 c/cs2100 t/Foundation\n"
        + "\t\t\t\t\t\t\tedit cs1231 t/ (to remove tags)\n\n";
    public static final String FIND_COMMAND = "To find a" + "\t\t\tType \"find\" followed by the respective "
        + "keywords or tags.\n"
        + "specific module" + "\t\t(You can specify multiple keywords or tags)\n"
        + "or a group of\n"
        + "modules with" + "\t\tNote:\n"
        + "common tags" + "\t\tKeywords can be specified as a sequence of characters of a\n"
        + "or keywords:" + "\t\tmodule code whereas tags must be specified fully.\n\n"
        + "\t\t\t\tExample(s):\tfind cs1231\n"
        + "\t\t\t\t\t\t\tfind cs st (to find modules which module codes\n"
        + "\t\t\t\t\t\t\tcontain \"cs\" or \"st\")\n"
        + "\t\t\t\t\t\t\tfind foundation (to find modules with\n"
        + "\t\t\t\t\t\t\t\"foundation\" as a tag)\n\n";
    public static final String SEARCH_COMMAND = "To view details" + "\t\tType \"search\" followed by a "
        + "valid module code.\n"
        + "of a module:\n"
        + "\t\t\t\tExample(s):\tsearch cs1231\n\n";
    public static final String REQUIRED_COMMAND = "To view all" + "\t\t\tType \"required\".\n"
        + "your required\nmodules:\n\n";
    public static final String CHECKMC_COMMAND = "To check\t\t\tType \"checkmc\".\n"
        + "your total MCs:\n\n";
    public static final String TAG_COMMAND = "To view all" + "\t\t\tType \"tags\"\n"
        + "your tags:\n\n";
    public static final String LIST_COMMAND = "To list all" + "\t\t\tType \"list\".\n"
        + "your completed\nmodules:\n\n";
    public static final String CLEAR_COMMAND = "To clear GradPad:\tType \"clear\"\n\n";
    public static final String EXIT_COMMAND = "To exit GradPad:\t\tType \"exit\".\n\n";

    public static final String SHOWING_HELP_MESSAGE = ADD_COMMAND + DELETE_COMMAND + EDIT_COMMAND
        + FIND_COMMAND + SEARCH_COMMAND + REQUIRED_COMMAND + CHECKMC_COMMAND + TAG_COMMAND + LIST_COMMAND
        + CLEAR_COMMAND + EXIT_COMMAND;

    // list command
    public static final String LIST_COMMAND_WORD = "list";
    public static final String MESSAGE_LIST_SUCCESS = "All your modules have been listed!";

    // required command
    public static final String REQUIRED_COMMAND_WORD = "required";

    // science command
    public static final String SCIENCE_COMMAND_WORD = "science";
    public static final String MESSAGE_SCIENCE_SUCCESS = "Science modules:";
    public static final String MESSAGE_FAILURE_SCIENCE = "Oh no, there was an error loading the required "
        + "Science Modules...";

    // search command
    public static final String SEARCH_COMMAND_WORD = "search";
    public static final String MESSAGE_SEARCH_USAGE = SEARCH_COMMAND_WORD + "\n\n"
        + "Format: search MODULE_CODE\n\n"
        + MESSAGE_MORE_INFO;
    public static final String MESSAGE_SEARCH_SUCCESS = "Module details for %1$s \n\n"
        + "Module Title: %3$s \n"
        + "Modular Credits: %2$s\n\n"
        + "Module Description: \n%4$s \n\n"
        + "Preclusion(s): \n%5$s\n\n"
        + "Prerequisite(s): \n%6$s\n";

    // tags command
    public static final String TAGS_COMMAND_WORD = "tags";
    public static final String MESSAGE_TAGS_SUCCESS = "All tags:\n";
    public static final String MESSAGE_NO_TAGS = "You have not included any tags.";

    // yes command
    public static final String YES_COMMAND_WORD = "yes";
    public static final String MESSAGE_NO_CONFIRMATION = "There is nothing to confirm!";

    // logic manager messages
    public static final String FILE_OPS_ERROR_MESSAGE = "Could not save data to file: ";
    public static final String MESSAGE_CONFIRMATION_CANCEL = "Command aborted - ";
}
