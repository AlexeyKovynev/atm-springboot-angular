import {TransactionCategory} from "./transaction-category";

export class AccountTransaction {
  constructor(public transactionDate: Date,
              public amount: number,
              public note: string,
              public transactionCategory: TransactionCategory) {
  }
}
