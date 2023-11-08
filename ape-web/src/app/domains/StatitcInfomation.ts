interface InnterItem {
  id: number;
  name: string;
}

export interface StatitcInfomation {
  genresNames: string[];
  typesNames: string[];
  companyiesNames: string[];
  artistsNames: string[];
  recordLabelList: string[];
  recordNames: InnterItem[];
  instrumentNames: InnterItem[];
}
