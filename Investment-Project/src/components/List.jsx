import { calculateInvestmentResults, formatter } from "../util/investment.js";

export default function List({ userInput }) {
  let calculation = calculateInvestmentResults(userInput);
  const initialInvestment =
    calculation[0].valueEndOfYear -
    calculation[0].interest -
    calculation[0].annualInvestment;
  console.log(calculation);
  return (
    <table id="result">
      <thead>
        <tr>
          <th>Year</th>
          <th>Investment Value</th>
          <th>Interest(Year)</th>
          <th>Total Interset</th>
          <th>Invested Capital</th>
        </tr>
      </thead>
      <tbody>
        {calculation.map((data, index) => {
          const totalInterst =
            data.valueEndOfYear -
            data.annualInvestment * data.year -
            initialInvestment;
          const totalAmtInvested = data.valueEndOfYear - totalInterst;
          return (
            <tr key={index}>
              <td>{data.year}</td>
              <td>{formatter.format(data.valueEndOfYear)}</td>
              <td>{formatter.format(data.interest)}</td>
              <td>{formatter.format(totalInterst)}</td>
              <td>{totalAmtInvested}</td>
            </tr>
          );
        })}
      </tbody>
    </table>
  );
}
