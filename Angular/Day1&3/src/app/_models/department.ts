export class Department {
  constructor(
    public name: string,
    public code: string,
    public available: Date,
    public price: number,
    public rate: number,
    public image: string
  ) {}
}
