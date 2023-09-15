public class Main {
    public static void main(String[] args) {
        String login = "Kosыtya231";
        String password = "12311";
        String confirmPassword = "12311";
        checkingError(login, password, confirmPassword);
    }

    public static void checkingLogin(String login) {
        if (login.length() > 20) {
            throw new WrongLoginException("Неверный логин, попробуйте снова");
        }
        char[] arrayLogin = login.toCharArray();
        for (int i = 0; i < login.length(); i++) {
            if (!(arrayLogin[i] == '_') && (!(arrayLogin[i] >= '0' && arrayLogin[i] <= '9')) &&
                    (!((arrayLogin[i] >= 'A' && arrayLogin[i] <= 'Z')
                            || (arrayLogin[i] >= 'a' && arrayLogin[i] <= 'z')))) {
                throw new WrongLoginException("Неверный логин, попробуйте снова");
            }
        }
    }


    public static void checkingPassword(String password) {
        if (password.length() > 20) {
            throw new WrongLoginException("Неверный пароль, попробуйте снова");
        }
        char[] arrayPassword = password.toCharArray();
        for (int i = 0; i < password.length(); i++) {
            if (!(arrayPassword[i] == '_') && (!(arrayPassword[i] >= '0' && arrayPassword[i] <= '9')) &&
                    (!((arrayPassword[i] >= 'A' && arrayPassword[i] <= 'Z')
                            || (arrayPassword[i] >= 'a' && arrayPassword[i] <= 'z')))) {
                throw new WrongPasswordException("Неправильный пароль, попробуйте снова");
            }
        }
    }

    public static void checkingConfirmPassword(String password, String confirmPassword) {
        if (!(password.equals(confirmPassword))) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

    public static void checkingError(String login, String password, String confirmPassword) {
        try {
            checkingLogin(login);
            checkingPassword(password);
            checkingConfirmPassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Неожиданная ошибка " + e.getMessage());
        }
    }
}