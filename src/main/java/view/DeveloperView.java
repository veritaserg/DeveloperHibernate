package view;

import controller.DeveloperController;
import model.Account;
import model.Developer;
import model.Skill;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeveloperView {
    DeveloperController developerController;
    SkillView skillView;

    public DeveloperView() {
        developerController = new DeveloperController();
        skillView = new SkillView();
    }

    public void create() {
        developerController.create(createDev(false));
    }

    public void getAll() {
        List<Developer> developers = developerController.getAll();
        if (developers.isEmpty()) {
            ConsoleHelper.writeToConsole("\nThere are no records to view.\n");
        } else {
            for (Developer dev : developers) {
                writeById(dev);
            }
        }
    }

    public void getById() {
        while (true) {
            ConsoleHelper.writeToConsole("Input ID:");
            try {
                Long id = Long.valueOf(Integer.parseInt(ConsoleHelper.readString()));
                writeById(developerController.getById(id));
                break;
            } catch (IOException e) {
                ConsoleHelper.writeToConsole("Wrong ID. Try again.\n");
            }
        }
    }

    private void writeById(Developer dev) {
        if (dev == null || (dev.getId() == 0 && dev.getFirstName() == null)) {
            ConsoleHelper.writeToConsole("\nThere is no such ID\n");
        } else {
            ConsoleHelper.writeToConsole("\n" + "ID = " + dev.getId() +
                    " || FirstName: " + dev.getFirstName() +
                    " || LastName: " + dev.getLastName() +
                    " || Specialty: " + dev.getSpecialty() +
                    " || Account:  " + dev.getAccount() +
                    " || Skill:" + dev.getSkills()
            );
        }
    }

    public void update() {
        ConsoleHelper.writeToConsole("Creating Developer for update ...");
        developerController.update(createDev(true));
    }

    public void delete() {
        while (true) {
            ConsoleHelper.writeToConsole("Input ID:");
            try {
                Long id = Long.valueOf(ConsoleHelper.readString());
                developerController.delete(id);
                break;
            } catch (IOException e) {
                ConsoleHelper.writeToConsole("Wrong ID. Try again.\n");
            }
        }
    }

    private Developer createDev(boolean b) {
        Developer developer;
        Long id = 0l;
        String firstname;
        String lastname;
        String specialty;
        Account account;
        Set<Skill> skills = new HashSet<>();

        if (b) {
            while (true) {
                try {
                    ConsoleHelper.writeToConsole("Input ID");
                    id = Long.valueOf(ConsoleHelper.readString());
                    break;
                } catch (IOException e) {
                    ConsoleHelper.writeToConsole("Failed input. Try again");
                }
            }
        }
        while (true) {
            try {
                ConsoleHelper.writeToConsole("Input firstname Developer");
                firstname = ConsoleHelper.readString();
                break;
            } catch (IOException e) {
                ConsoleHelper.writeToConsole("Failed input. Try again");
            }
        }

        while (true) {
            try {
                ConsoleHelper.writeToConsole("Input lastname of Developer");
                lastname = ConsoleHelper.readString();
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (true) {
            try {
                ConsoleHelper.writeToConsole("Input specialty of Developer");
                specialty = ConsoleHelper.readString();
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        while (true) {
            try {
                ConsoleHelper.writeToConsole("Input Account of you repository");
                String acname = ConsoleHelper.readString();
                account = new Account(acname);
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            try {
                ConsoleHelper.writeToConsole("Input skill's  of developer: (for finish input 'exit')");
                String str;
                while (!(str = ConsoleHelper.readString()).equalsIgnoreCase("exit")) {
                    {
                        try {
                            skills.add(new Skill(str));
                        } catch (NumberFormatException e) {
                            ConsoleHelper.writeToConsole("Wrong integer. Try again");
                        }
                    }
                }
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new Developer(id, firstname, lastname, specialty, account, skills);
    }
}
