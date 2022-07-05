export class OperationResult {
    public result: number;
    public error: boolean;
    public message: string;

    constructor(result: number, error: boolean, message ?: string){
        this.result = result;
        this.error = error;
        this.message = message;
    }
}
