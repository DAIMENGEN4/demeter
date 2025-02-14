export class DateUtils {
    static getGreeting(): string {
        const currentHour = new Date().getHours();
        if (currentHour < 6) {
            return "Early morning";
        } else if (currentHour < 12) {
            return "Good morning";
        } else if (currentHour < 17) {
            return "Good afternoon";
        } else if (currentHour < 21) {
            return "Good evening";
        } else {
            return "Good night";
        }
    }
}