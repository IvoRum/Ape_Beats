import { ItemSale } from './ItemSale';

export interface UserSales {
  number: number;
  amount: number;
  fulfill: boolean;
  utems: ItemSale[];
}
